package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {
    protected long id;
    protected String Name;
    protected int level;
    protected String Ultimate;
}
