package me.nalab.core.data.survey;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import me.nalab.core.data.common.TimeBaseEntity;

@Entity
@Table(name = "survey")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Survey extends TimeBaseEntity {

	@Id
	@Column(name = "survey_id")
	private Long id;

	@OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
	private List<FormQuestion> formQuestionableList;

	@JoinColumn(name = "target_id", nullable = false)
	private Long targetId;

}
