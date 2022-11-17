package io.munkush.com.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class EmployeeIncorrectData {
    private String info;
    private String dateTime;
}
