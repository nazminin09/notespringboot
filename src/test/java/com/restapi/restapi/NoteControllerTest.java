// package com.restapi.restapi;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.restapi.restapi.controller.NoteController;
// import com.restapi.restapi.model.Note;
// import com.restapi.restapi.repository.NoteRepository;

// import org.hamcrest.Matchers;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.boot.test.context.SpringBootTest;


// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// import static org.hamcrest.Matchers.*;


// @ExtendWith(SpringExtension.class)
// @ContextConfiguration(classes=RestapiApplication.class)
// @SpringBootTest
// @AutoConfigureMockMvc
// public class NoteControllerTest {
//     @Autowired
//     MockMvc mockMvc;
//     @Autowired
//     ObjectMapper mapper;

// 	@MockBean
// 	NoteRepository noterepository;

// 	Note record1 = new Note(1,"test", "test");
// 	Note record2 = new Note(2,"test2", "test2");
// 	Note record3 = new Note(3, "test3", "test3");
  
//     //unit testing for get request handler
// 	@Test
// 	public void getAllNotes_success() throws Exception {
// 		List<Note> records = new ArrayList<>(Arrays.asList(record1,record2,record3));

// 		Mockito.when(noterepository.findAll()).thenReturn(records);

// 		mockMvc.perform(MockMvcRequestBuilders
//             .get("/api/notes")
//             .contentType(MediaType.APPLICATION_JSON))
//             .andExpect(status().isOk())
//             .andExpect(jsonPath("$", hasSize(3)))
//             .andExpect(jsonPath("$[2].title", is("test3")));
// 	}
//     // get notes by id test
// 	@Test
// 	public void getNoteById_success() throws Exception {
// 		Mockito.when(noterepository.findById(record1.getId())).thenReturn(java.util.Optional.of(record1));

// 		mockMvc.perform(MockMvcRequestBuilders
// 		.get("/api/notes/1")
// 		.contentType(MediaType.APPLICATION_JSON))
// 		.andExpect(status().isOk())
// 		.andExpect(jsonPath("$", notNullValue()))
// 		.andExpect(jsonPath("$.title", is("test")));
// 	}
//     //find all test
//     @Test
//     public void testfindAll() throws Exception {
//         Note record4 = new Note(1,"rec4","rec43");
//         List<Note> records = Arrays.asList(record4);

//         Mockito.when(noterepository.findAll()).thenReturn(records);

//         mockMvc.perform(get("/api/notes"))
//             .andExpect(status().isOk())
//             .andExpect(jsonPath("$", Matchers.hasSize(1)))
//             .andExpect(jsonPath("$[0].title", Matchers.is("rec4")));
//     }

//     @Test
//     public void createNotes_success() throws Exception {
//         Note recordnew = Note.builder()
//         .id((long) 9)
//         .title("title 9")
//         .content("title 9 content")
//         .build();

//         Mockito.when(noterepository.save(recordnew)).thenReturn(recordnew);
        
//         MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/notes")
//             .contentType(MediaType.APPLICATION_JSON)
//             .accept(MediaType.APPLICATION_JSON)
//             .content(this.mapper.writeValueAsString(recordnew));

//         mockMvc.perform(mockRequest)
//             .andExpect(status().isOk())
//             .andExpect(jsonPath("$", notNullValue()))
//             .andExpect(jsonPath("$.title", is("title 9")));
            
//     }

//     @Test
//     public void updateNote_success() throws Exception {
//         Note noteupdate = Note.builder()
//         .id((long) 8)
//         .title("title update")
//         .content("content update")
//         .build();

//         Mockito.when(noterepository.findById(record1.getId())).thenReturn(Optional.of(record1));
//         Mockito.when(noterepository.save(noteupdate)).thenReturn(noteupdate);

//         MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/notes")
//             .contentType(MediaType.APPLICATION_JSON)
//             .accept(MediaType.APPLICATION_JSON)
//             .content(this.mapper.writeValueAsString(noteupdate));

//         mockMvc.perform(mockRequest)
//             .andExpect(status().isOk())
//             .andExpect(jsonPath("$", notNullValue()))
//             .andExpect(jsonPath("$.title", is("title update")));
//     }

//     @Test
//     public void deleteNoteById_success() throws Exception {
//         Mockito.when(noterepository.findById(record2.getId())).thenReturn(Optional.of(record2));

//         mockMvc.perform(MockMvcRequestBuilders
//         .delete("/api/notes/2")
//         .contentType(MediaType.APPLICATION_JSON))
//         .andExpect(status().isOk());
        
//     }


// }
