package com.example.demojparelationshipbeforeclass.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleBaseRuleRDto {

    private RuleDto ruleDto;
    private BaseRuleDto baseRuleDto;
    private Date regDTM;
    private String regrID;
    private Date modDTM;
    private String modrID;

}
