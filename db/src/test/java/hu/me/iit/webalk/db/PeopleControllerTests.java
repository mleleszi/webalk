package hu.me.iit.webalk.db;

import hu.me.iit.webalk.db.repository.People;
import hu.me.iit.webalk.db.repository.PeopleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class PeopleControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PeopleRepository peopleRepository;

	@Test
	public void shouldNoMainPage() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().is4xxClientError());
	}

	@Test
	public void shouldReturnPeople() throws Exception {
		// given
		People people = new People(1L, 12, "sanyi");
		peopleRepository.save(people);

		// when then
		this.mockMvc.perform(get("/people"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("[{\"id\":1,\"name\":\"sanyi\",\"age\":12}]"));


	}

	@Test
	public void shouldReturnPeople2() throws Exception {
		// given
		People people = new People(1L, 12, "asd");
		peopleRepository.save(people);

		// when then

		this.mockMvc.perform(get("/people"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("@.[0].age", is(12)))
				.andExpect(jsonPath("@.[0].name", is("asd")));


	}

	@Test
	void contextLoads() {
	}



}
