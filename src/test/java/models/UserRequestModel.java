package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserRequestModel {
    String name, job;
}
