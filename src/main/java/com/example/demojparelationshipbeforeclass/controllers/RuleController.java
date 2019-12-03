package com.example.demojparelationshipbeforeclass.controllers;

import com.example.demojparelationshipbeforeclass.dto.BaseRuleDto;
import com.example.demojparelationshipbeforeclass.dto.RuleDto;
import com.example.demojparelationshipbeforeclass.dto.Wrapper;
import com.example.demojparelationshipbeforeclass.entities.dlm.BaseRule;
import com.example.demojparelationshipbeforeclass.entities.dlm.Rule;
import com.example.demojparelationshipbeforeclass.entities.dlm.RuleBaseRuleR;
import com.example.demojparelationshipbeforeclass.repositories.BaseRuleRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/rules")
public class RuleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ModelMapper modelMapper;

    private BaseRuleRepository baseRuleRepository;

    public RuleController(ModelMapper modelMapper, BaseRuleRepository baseRuleRepository) {
        this.modelMapper = modelMapper;
        this.baseRuleRepository = baseRuleRepository;
    }

    @PostMapping
    public String insert(@RequestBody Wrapper dto) {

        BaseRule baseRule = this.modelMapper.map(dto.getBaseRuleDto(), BaseRule.class);
        logger.info("Base Rule: {}", baseRule);

        this.baseRuleRepository.save(baseRule);

        Rule rule = this.modelMapper.map(dto.getRuleDto(), Rule.class);
        logger.info("Rule: {}", rule);

        RuleBaseRuleR ruleBaseRuleR = this.modelMapper.map(dto.getRuleBaseRuleRDto(), RuleBaseRuleR.class);
        logger.info("Rule Base Rule: {}", ruleBaseRuleR);

        return dto.getRuleDto().getDesc();
    }


}
