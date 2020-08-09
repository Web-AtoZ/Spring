package com.webatoz.backend.services.restaurant.menu;

import com.webatoz.backend.database.webatoz.restaurant.Restaurant;
import com.webatoz.backend.database.webatoz.restaurant.menu.CollectMenuRepository;
import com.webatoz.backend.database.webatoz.restaurant.menu.Menu;
import com.webatoz.backend.services.restaurant.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CollectMenuService {

    final String testURL = "https://store.naver.com/restaurants/detail?id=38009643&tab=menu#_tab";

    private final CollectMenuRepository collectMenuRepository;

    private final RestaurantService restaurantService;

//    @PostConstruct
    public List<Menu> testMethod() throws IOException {
        Document doc = Jsoup.connect(testURL).get();

        List<Menu> menus = new ArrayList<>();

        // HTML 소스코드에서 메뉴이름 및 가격 추출하여 리스트에 저장
        Elements menuAreaDIV = doc.select("div.txt_menu_area");
        Iterator<Element> menuListDIV = menuAreaDIV.select("ul.list_txt_menu").iterator();

        while (menuListDIV.hasNext()) {
            Iterator<Element> menuListItems = menuListDIV.next().select("li.list_item").iterator();
            while (menuListItems.hasNext()) {
                Element menuItem = menuListItems.next();
                Menu menu = new Menu();
                int menuPrice = Integer.parseInt(
                        menuItem.select("div.price")
                                .text()
                                .replace(",","")
                                .replace("원","")
                );

                String menuName = menuItem.select("div.tit").text();

                menu.setPrice(menuPrice);
                menu.setName(menuName);
                menus.add(menu);
            }
        }

        return menus;
    }

    @PostConstruct
//    @Scheduled(cron = "10 * * * * *") // 임시로 매분 10초로 지정
    public void collectRestaurantMenu() {
        // 식당 url목록 가져오기
        List<Restaurant> restaurants = getRestaurants();

        try {
            // 조회한 각 식당 객체의 url을 이용해 크롤링 및 메뉴 데이터 저장
            for (Restaurant restaurant : restaurants) {

//                int restaurantId = restaurant.getRestaurantId();
                String restaurantId = "38009643";

                // 식당 url 얻기
                String restaurantURL = getRestaurantURLById(restaurantId);

                // 식당 url 빈값 이거나 null인 경우 url 호출 x
                if (restaurantURL.isEmpty() || restaurantURL == null) continue;

                // 레스토랑 url로 크롤링 시작하여 메뉴정보 얻어오기
                List<Menu> menus = getMenusByCrawling(testURL);
                
                for (Menu menu : menus) {
                    // menu 객체에 식당 id 저장
                    menu.setRestaurantId(restaurant.getRestaurantId());

                    // menu insert 실행
                    collectMenuRepository.save(menu);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getRestaurantURLById(String restaurantId) {

        String preFixURL = "https://store.naver.com/restaurants/detail?id=";
        String surFixURL = "&tab=menu#_tab";

        return restaurantId == null || restaurantId.isEmpty() ?
                null : preFixURL+ restaurantId +surFixURL;

    }

    private List<Restaurant> getRestaurants() {
        Restaurant restaurant = new Restaurant();
        // 식당리스트 가져오기
        Page<Restaurant> restaurants = restaurantService.getRestaurants(restaurant, PageRequest.of(10, 1));

        return restaurants.getContent();
    }

    /**
     * url을 이용하여 크롤링 후 식당 메뉴 데이터 가공후 반환.
     * @param restaurantURL 식당 url
     * */
    private List<Menu> getMenusByCrawling(String restaurantURL) throws IOException {

        Document doc = Jsoup.connect(testURL).get();

        List<Menu> menus = new ArrayList<>();

        // HTML 소스코드에서 메뉴이름 및 가격 추출하여 리스트에 저장
        Elements menuAreaDIV = doc.select("div.txt_menu_area");
        Iterator<Element> menuListDIV = menuAreaDIV.select("ul.list_txt_menu").iterator();

        while (menuListDIV.hasNext()) {
            Iterator<Element> menuListItems = menuListDIV.next().select("li.list_item").iterator();
            while (menuListItems.hasNext()) {
                Element menuItem = menuListItems.next();
                Menu menu = new Menu();
                int menuPrice = Integer.parseInt(
                        menuItem.select("div.price")
                                .text()
                                .replace(",","")
                                .replace("원","")
                );

                String menuName = menuItem.select("div.tit").text();

                menu.setPrice(menuPrice);
                menu.setName(menuName);
                menus.add(menu);
            }
        }

        return menus;
    }

}
