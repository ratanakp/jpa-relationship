package com.example.demojparelationshipbeforeclass.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Wrapper {

    private RuleDto ruleDto;
    private BaseRuleDto baseRuleDto;
    private RuleBaseRuleRDto ruleBaseRuleRDto;

}
