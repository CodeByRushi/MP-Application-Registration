package in.rushikesh.bindings;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CitizenApplication {

	private String fullname;

	private String email;

	private Long phno;

	private Long ssn;

	private String gender;

	private LocalDate dob;
}
