package com.webatoz.backend.services.restaurant.menu;

import com.webatoz.backend.database.webatoz.restaurant.Restaurant;
import com.webatoz.backend.database.webatoz.restaurant.RestaurantRepository;
import com.webatoz.backend.database.webatoz.restaurant.menu.CollectMenuRepository;
import com.webatoz.backend.database.webatoz.restaurant.menu.Menu;
import com.webatoz.backend.services.restaurant.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.apache.xmlbeans.impl.jam.mutable.MElement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CollectMenuService {

    final String restaurantMenuURL = "";

    private final CollectMenuRepository collectMenuRepository;

    private final RestaurantService restaurantService;

    @Scheduled(cron = "10 * * * * *") // 임시로 매분 10초로 지정
    @Transactional
    public void collectRestaurantMenu() {
        // 식당 url목록 가져오기
        List<Restaurant> restaurants = getRestaurants();

        try {
            // 조회한 식당 목록의 각 객체에서 url
            for (Restaurant restaurant : restaurants) {
                // 레스토랑 url로 크롤링 시작하여 메뉴정보 얻어오기 - 임시로 주소로 해둠
                List<Menu> menus = getMenusByCrawling(restaurant.getAddress());

                for (Menu menu : menus) {

                    // menu 객체에 식당 id 저장
                    // menu.setRestaurantId(restaurant.getRestaurantId);

                    // menu insert 실행
                    collectMenuRepository.insertMenu(menu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private List<Restaurant> getRestaurants() {
        Restaurant restaurant = new Restaurant();

        // 식당리스트 가져오기
        Page<Restaurant> restaurants = restaurantService.getRestaurants(restaurant, null);

        return null;
    }

    /**
     * url을 이용하여 크롤링 후 식당 메뉴 데이터 가공후 반환.
     * @param restaurantURL 식당 url
     * */
    private List<Menu> getMenusByCrawling(String restaurantURL) {
        // url을 이용해 크롤링 작업


        List<Object> UnconvertedMenus = new ArrayList<>();

        // 메뉴데이터 가공
        List<Menu> menus = getConvertMenusData(UnconvertedMenus);

        return menus;
    }

    /**
     * 크롤링한 데이터를 메뉴데이터 리스트로 변환환 후 반
     * @param UnconvertedMenus 가공되지 않은 메뉴목록
     * */
    private List<Menu> getConvertMenusData(List<Object> UnconvertedMenus) {

        List<Menu> menus = new ArrayList<>();

        for (Object unConvertedMenu : UnconvertedMenus) {
            // 가공되지않은 메뉴데이터를 가공하여 메뉴 객체에 저장

            Menu menu = new Menu();

            menus.add(menu);
        }

        return menus;
    }

}
