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
  public void getBoards() throws Exception {
    mockMvc.perform(
        get("/boards")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .accept(MediaTypes.HAL_JSON)
    )
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(document("get-boards",
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
                fieldWithPath("_embedded.boards").description("list of board"),
                fieldWithPath("_embedded.boards[].id").description("id"),
                fieldWithPath("_embedded.boards[].title").description("title"),
                fieldWithPath("_embedded.boards[].created_date").description("created_date")
                    .optional(),
                fieldWithPath("_embedded.boards[].updated_date").description("updated_date")
                    .optional(),
                fieldWithPath("_embedded.boards[].deleted_date").description("deleted_date")
                    .optional(),
                fieldWithPath("page.size").description("elements size per page"),
                fieldWithPath("page.total_elements").description("total element count of results"),
                fieldWithPath("page.total_pages").description("total page count"),
                fieldWithPath("page.number").description("current page")
            )
        ));
  }

}