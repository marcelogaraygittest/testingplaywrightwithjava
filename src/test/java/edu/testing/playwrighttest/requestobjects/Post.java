package edu.testing.playwrighttest.requestobjects;

import lombok.Getter;
import lombok.Setter;

public class Post {
    @Getter @Setter
    private String title;

    @Getter @Setter
    private String body;

    @Getter @Setter
    private int  userId;

    @Getter @Setter
    private int  id;
}
