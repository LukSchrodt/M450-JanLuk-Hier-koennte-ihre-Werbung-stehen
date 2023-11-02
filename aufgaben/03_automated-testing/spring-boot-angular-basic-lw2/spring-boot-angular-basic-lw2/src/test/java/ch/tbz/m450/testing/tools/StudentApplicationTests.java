package ch.tbz.m450.testing.tools;

import ch.tbz.m450.testing.tools.controller.StudentController;
import ch.tbz.m450.testing.tools.repository.entities.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Random;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class StudentApplicationTests {

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private MockMvc mvc;

	@InjectMocks
	private StudentController studentController;

	@Test
	void testAddStudentShouldSaveStudent() throws Exception {
		// Given
		Student student = createStudent();
		ObjectMapper objectMapper = new ObjectMapper();

		// When
		studentController.addStudent(student);

		// Then
		mvc.perform(post("/students").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(objectMapper.writeValueAsString(student))).andExpect(status().isOk());
	}
	public Student createStudent() {
		String firstName = randomName();
		return new Student(firstName, firstName + "@mail.com");
	}

	private String randomName() {
		int leftLimit = 97; // 'a'
		int rightLimit = 122; // 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + random.nextInt(rightLimit - leftLimit + 1);
			buffer.append((char) randomLimitedInt);
		}
		return buffer.toString();
	}
}
