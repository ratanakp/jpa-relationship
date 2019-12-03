package com.example.demojparelationshipbeforeclass.entities.dlm;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "\"RULE_BASE_RULE_R\"")
public class RuleBaseRuleR implements Serializable {

    @Id
    @ManyToOne(targetEntity = Rule.class)
    @JoinColumn(name = "\"RULE_ID\"")
    private Rule rule;

    @Id
    @ManyToOne(targetEntity = BaseRule.class)
    @JoinColumn(name = "\"BASE_RULE_ID\"")
    private BaseRule baseRule;

    // extra columns

    @Column(name = "\"REG_DTM\"")
    private Date regDTM;

    @Column(length = 50, name = "\"REGR_ID\"")
    private String regrID;

    @Column(name = "\"MOD_DTM\"")
    private Date modDTM;

    @Column(length = 50, name = "\"MODR_ID\"")
    private String modrID;

    public RuleBaseRuleR(BaseRule baseRule,
                         Date regDTM, String regrID, Date modDTM, String modrID) {

        this.baseRule = baseRule;

        this.regDTM = regDTM;
        this.regrID = regrID;
        this.modDTM = modDTM;
        this.modrID = modrID;
    }
}
