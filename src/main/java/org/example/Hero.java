package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@NoArgsConstructor
public class Hero {
    long id;
    String Name;
    int level;
    String Ultimate;

}
