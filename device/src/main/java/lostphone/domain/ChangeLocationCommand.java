package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ChangeLocationCommand {

    private Float latitude;
    private Float longitude;
}
