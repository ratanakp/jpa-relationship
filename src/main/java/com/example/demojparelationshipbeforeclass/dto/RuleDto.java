package com.example.demojparelationshipbeforeclass.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleDto {

    private Integer ruleId;
    private String ruleNM;
    private int moveCycle;
    private int deleteCycle;
    private String desc;
    private String memo;
    private Date regDTM;
    private String regrID;
    private Date modDTM;
    private String modrID;

}
