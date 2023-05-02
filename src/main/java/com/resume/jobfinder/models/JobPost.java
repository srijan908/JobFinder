package com.resume.jobfinder.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "jobFinder")
public class JobPost {
    String profile;
    String desc;
    String exp;
    List<String> techs;
}
