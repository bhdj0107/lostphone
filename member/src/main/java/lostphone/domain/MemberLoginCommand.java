package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class MemberLoginCommand {

    private Long id;
    private String name;
    private String contact;
}
