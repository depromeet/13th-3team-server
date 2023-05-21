package me.nalab.survey.domain.survey;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.function.LongSupplier;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import me.nalab.survey.domain.exception.IdAlreadyGeneratedException;
import me.nalab.survey.domain.support.IdGeneratable;

@SuperBuilder
@Getter
@ToString
@EqualsAndHashCode
public abstract class FormQuestionable implements IdGeneratable, Comparable<FormQuestionable> {

	protected Long id;
	protected final String title;
	protected final LocalDateTime createdAt;
	protected final LocalDateTime updatedAt;
	protected final Integer order;
	protected final QuestionType questionType;

	@Override
	public void withId(LongSupplier idSupplier) {
		if(id != null) {
			throw new IdAlreadyGeneratedException(this);
		}
		this.id = idSupplier.getAsLong();
		cascadeId(idSupplier);
	}

	protected void cascadeId(LongSupplier idSupplier) {
	}

	@Override
	public int compareTo(FormQuestionable other) {
		return Comparator.comparingInt(FormQuestionable::getOrder)
			.compare(this, other);
	}
}
