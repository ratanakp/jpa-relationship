package com.example.demojparelationshipbeforeclass.entities.dlm;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
@EqualsAndHashCode*/

@Getter
@Setter
@ToString
@Entity
//@Table(name = "\"RULE\"")
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "\"RULE_ID\"")
    private Integer ruleId;

    @Column(name = "\"RULE_NM\"")
    private String ruleNM;

    @Column(name = "\"MOVE_CYCLE\"", length = 10)
    private int moveCycle;

    @Column(name = "\"DELETE_CYCLE\"", length = 10)
    private int deleteCycle;

    @Column(columnDefinition = "text", name = "\"DESC\"")
    private String desc;

    @Column(columnDefinition = "text", name = "\"MEMO\"")
    private String memo;

    @Column(name = "\"REG_DTM\"")
    private Date regDTM;

    @Column(length = 50, name = "\"REGR_ID\"")
    private String regrID;

    @Column(name = "\"MOD_DTM\"")
    private Date modDTM;

    @Column(length = 50, name = "\"MODR_ID\"")
    private String modrID;

    @OneToMany(mappedBy = "rule", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<RuleBaseRuleR> ruleBaseRuleRS = new HashSet<>();

    public Rule() {
    }

    public Rule(String ruleNM, int moveCycle, int deleteCycle, String desc, String memo,
                Date regDTM, String regrID, Date modDTM, String modrID,

                RuleBaseRuleR... ruleBaseRuleRSs) {

        this.ruleNM = ruleNM;
        this.moveCycle = moveCycle;
        this.deleteCycle = deleteCycle;
        this.desc = desc;
        this.memo = memo;
        this.regDTM = regDTM;
        this.regrID = regrID;
        this.modDTM = modDTM;
        this.modrID = modrID;

        for (RuleBaseRuleR r :
                ruleBaseRuleRSs) {
            r.setRule(this);
        }

        this.ruleBaseRuleRS = Stream.of(ruleBaseRuleRSs).collect(Collectors.toSet());
    }

}
