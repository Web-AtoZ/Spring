package com.webatoz.backend.interfaces.restaurant;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.webatoz.backend.config.RestDocsConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "webatoz.com", uriPort = 443)
@Import(RestDocsConfiguration.class)
public class RestaurantControllerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  public void getRestaurantsTest() throws Exception {
    mockMvc
        .perform(
            get("/restaurants")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON)
                    .param("name", "")
                    .param("optionName", ""))
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(
            document(
                "get-restaurants",
                requestHeaders(
                    headerWithName("Content-Type").description("application/json"),
                    headerWithName("Accept").description("application/hal+json")),
                requestParameters(
                    parameterWithName("name").description("The restaurant name").optional(),
                    parameterWithName("optionName").description("The category name").optional(),
                    parameterWithName("page")
                        .description("The page to retrieve (default=1)")
                        .optional(),
                    parameterWithName("size")
                        .description("Entries per page (default=20)")
                        .optional()),
                links(
                    linkWithRel("self").description("link to self"),
                    linkWithRel("profile").description("document link"),
                    linkWithRel("first").description("The first page of results").optional(),
                    linkWithRel("prev").description("The previous page of results").optional(),
                    linkWithRel("next").description("The next page of results").optional(),
                    linkWithRel("last").description("The last page of results").optional()),
                relaxedResponseFields(
                    fieldWithPath("_embedded.restaurants").description("list of restaurant"),
                    fieldWithPath("_embedded.restaurants[].restaurant_id").description("id"),
                    fieldWithPath("_embedded.restaurants[].name").description("name"),
                    fieldWithPath("_embedded.restaurants[].created_date")
                        .description("created_date")
                        .optional(),
                    fieldWithPath("_embedded.restaurants[].updated_date")
                        .description("updated_date")
                        .optional(),
                    fieldWithPath("_embedded.restaurants[].deleted_date")
                        .description("deleted_date")
                        .optional(),
                    fieldWithPath("_embedded.restaurants[].address")
                        .description("address")
                        .optional(),
                    fieldWithPath("_embedded.restaurants[].lng").description("lng").optional(),
                    fieldWithPath("_embedded.restaurants[].lat").description("lat").optional(),
                    fieldWithPath("_embedded.restaurants[].option_id")
                        .description("option_id")
                        .optional(),
                    fieldWithPath("_embedded.restaurants[].board_id")
                        .description("board_id")
                        .optional(),
                    fieldWithPath("_embedded.restaurants[].road_address")
                        .description("road_address")
                        .optional(),
                    fieldWithPath("_embedded.restaurants[].option_name")
                        .description("option_name")
                        .optional(),
                    fieldWithPath("_embedded.restaurants[].phone").description("phone").optional(),
                    fieldWithPath("page.size").description("elements size per page"),
                    fieldWithPath("page.total_elements")
                        .description("total element count of results"),
                    fieldWithPath("page.total_pages").description("total page count"),
                    fieldWithPath("page.number").description("current page"))));
  }
}
