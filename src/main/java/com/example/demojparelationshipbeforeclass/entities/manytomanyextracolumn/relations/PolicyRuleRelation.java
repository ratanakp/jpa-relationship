package com.example.demojparelationshipbeforeclass.entities.manytomanyextracolumn.relations;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"ruleId", "policyId"})
@Entity
@Table(name = "POLICY_RULE_R")
@IdClass(PolicyRuleId.class)
public class PolicyRuleRelation {

    @Id
    private Long ruleId;

    @Id
    private Long policyId;

    @Column(name = "REG_DTM")
    private LocalDateTime createdDate;

    @Column(name = "REGR_ID")
    private String creatorId;

    @Column(name = "MOD_DTM")
    private LocalDateTime modifiedDate;

    @Column(name = "MODR_ID")
    private String modifierId;

}
