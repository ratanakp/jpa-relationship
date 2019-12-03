package com.example.demojparelationshipbeforeclass.entities.dlm;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode*/

@Getter
@Setter
@Entity
@ToString
//@Table(name = "\"BASE_RULE\"")
public class BaseRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "\"BASE_RULE_ID\"")
    private Integer baseRuleId;

    @Column(name = "\"BASE_RULE_NM\"")
    private String baseRuleNM;

    @Column(name = "\"DFLT_MOVE_CYCLE\"", length = 10)
    private int DFLTMoveCycle;

    @Column(name = "\"DFLT_DELETE_CYCLE\"", length = 10)
    private int DFLTDeleteCycle;

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

    @OneToMany(mappedBy = "baseRule", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<RuleBaseRuleR> ruleBaseRuleRS = new HashSet<>();

    public BaseRule() {
    }

    public BaseRule(String baseRuleNM, int DFLTMoveCycle, int DFLTDeleteCycle, String desc,
                    String memo, Date regDTM, String regrID, Date modDTM, String modrID) {
        this.baseRuleNM = baseRuleNM;
        this.DFLTMoveCycle = DFLTMoveCycle;
        this.DFLTDeleteCycle = DFLTDeleteCycle;
        this.desc = desc;
        this.memo = memo;
        this.regDTM = regDTM;
        this.regrID = regrID;
        this.modDTM = modDTM;
        this.modrID = modrID;
    }
}
