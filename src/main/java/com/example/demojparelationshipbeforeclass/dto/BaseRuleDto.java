package com.example.demojparelationshipbeforeclass.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseRuleDto {

    private Integer baseRuleId;
    private String baseRuleNM;
    private int DFLTMoveCycle;
    private int DFLTDeleteCycle;
    private String desc;
    private String memo;
    private Date regDTM;
    private String regrID;
    private Date modDTM;
    private String modrID;

}
