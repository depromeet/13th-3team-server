package me.nalab.core.data.feedback;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceFormFeedbackEntity extends FormFeedbackEntity {

	@OneToMany(mappedBy = "choiceFormFeedbackEntity")
	private List<SelectEntity> selectList;
}
