package com.webatoz.backend.interfaces.board;

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
public class BoardControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getBoard() throws Exception {
    mockMvc.perform(
        get("/boards")
            .param("size", "1")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .accept(MediaTypes.HAL_JSON)
    )
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(document("get-board",
            requestHeaders(
                headerWithName("Content-Type").description("application/json"),
                headerWithName("Accept").description("application/hal+json")
            ),
            requestParameters(
                parameterWithName("page").description("The page to retrieve (default=1)")
                    .optional(),
                parameterWithName("size").description("Entries per page (default=20)").optional()
            ),
            links(
                linkWithRel("self").description("link to self"),
                linkWithRel("profile").description("document link"),
                linkWithRel("first").description("The first page of results").optional(),
                linkWithRel("prev").description("The previous page of results").optional(),
                linkWithRel("next").description("The next page of results").optional(),
                linkWithRel("last").description("The last page of results").optional()
            ),
            relaxedResponseFields(
                fieldWithPath("_embedded.board").description("list of board"),
                fieldWithPath("_embedded.board[].id").description("id").optional(),
                fieldWithPath("_embedded.board[].title").description("title").optional(),
                fieldWithPath("_embedded.board[].content").description("content").optional(),
                fieldWithPath("_embedded.board[].views").description("views").optional(),

                fieldWithPath("_embedded.board[].user").description("user").optional(),
                fieldWithPath("_embedded.board[].user.id").description("id").optional(),
                fieldWithPath("_embedded.board[].user.account").description("account").optional(),
                fieldWithPath("_embedded.board[].user.name").description("name").optional(),
                fieldWithPath("_embedded.board[].user.email").description("email").optional(),
                fieldWithPath("_embedded.board[].user.sns_type").description("sns type").optional(),
                fieldWithPath("_embedded.board[].user.sns_profile").description("sns profile").optional(),
                fieldWithPath("_embedded.board[].user.created_date").description("created date").optional(),
                fieldWithPath("_embedded.board[].user.updated_date").description("updated date").optional(),
                fieldWithPath("_embedded.board[].user.deleted_date").description("deleted date").optional(),

                fieldWithPath("_embedded.board[].category").description("category").optional(),
                fieldWithPath("_embedded.board[].category.id").description("id").optional(),
                fieldWithPath("_embedded.board[].category.name").description("name").optional(),
                fieldWithPath("_embedded.board[].category.description").description("description").optional(),
                fieldWithPath("_embedded.board[].category.pcategory_id").description("pcategory id").optional(),
                fieldWithPath("_embedded.board[].category.created_date").description("created date").optional(),
                fieldWithPath("_embedded.board[].category.updated_date").description("updated date").optional(),
                fieldWithPath("_embedded.board[].category.deleted_date").description("deleted date").optional(),

                fieldWithPath("_embedded.board[].restaurant").description("category").optional(),
                fieldWithPath("_embedded.board[].restaurant.id").description("id").optional(),
                fieldWithPath("_embedded.board[].restaurant.name").description("name").optional(),
                fieldWithPath("_embedded.board[].restaurant.lng").description("lng").optional(),
                fieldWithPath("_embedded.board[].restaurant.lat").description("lat").optional(),
                fieldWithPath("_embedded.board[].restaurant.option_id").description("option_id").optional(),
                fieldWithPath("_embedded.board[].restaurant.road_address").description("road_address").optional(),
                fieldWithPath("_embedded.board[].restaurant.option_name").description("option_name").optional(),
                fieldWithPath("_embedded.board[].restaurant.phone").description("phone").optional(),
                fieldWithPath("_embedded.board[].restaurant.place_id").description("place_id").optional(),
                fieldWithPath("_embedded.board[].restaurant.created_date").description("created date").optional(),
                fieldWithPath("_embedded.board[].restaurant.updated_date").description("updated date").optional(),
                fieldWithPath("_embedded.board[].restaurant.deleted_date").description("deleted date").optional(),


                fieldWithPath("_embedded.board[].created_date").description("created_date")
                    .optional(),
                fieldWithPath("_embedded.board[].updated_date").description("updated_date")
                    .optional(),
                fieldWithPath("_embedded.board[].deleted_date").description("deleted_date")
                    .optional(),
                fieldWithPath("page.size").description("elements size per page"),
                fieldWithPath("page.total_elements").description("total element count of results"),
                fieldWithPath("page.total_pages").description("total page count"),
                fieldWithPath("page.number").description("current page")
            )
        ));
  }

}