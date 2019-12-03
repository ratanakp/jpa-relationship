package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.relations;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"baseRuleId", "ruleId"})
@Entity
@Table(name = "RULE_BASE_RULE_R")
@IdClass(RuleBaseRuleId.class)
public class RuleBaseRuleRelation {

    @Id
    private Long baseRuleId;

    @Id
    private Long ruleId;

    @Column(name = "REG_DTM")
    private LocalDateTime createdDate;

    @Column(name = "REGR_ID")
    private String creatorId;

    @Column(name = "MOD_DTM")
    private LocalDateTime modifiedDate;

    @Column(name = "MODR_ID")
    private String modifierId;

}
