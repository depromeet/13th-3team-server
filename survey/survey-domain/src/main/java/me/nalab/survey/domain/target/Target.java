package me.nalab.survey.domain.target;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.LongSupplier;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import me.nalab.survey.domain.exception.IdAlreadyGeneratedException;
import me.nalab.survey.domain.support.IdGeneratable;
import me.nalab.survey.domain.survey.Survey;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class Target implements IdGeneratable {

    private static final Set<SurveyBookmark> NONE_BOOKMARKED_SURVEYS = new HashSet<>();

    private Long id;
    private final List<Survey> surveyList;
    private final String nickname;
    private final String job;
    private final String imageUrl;
    @Builder.Default
    private final Set<SurveyBookmark> bookmarkedSurveys = NONE_BOOKMARKED_SURVEYS;
    private String position;

    @Override
    public void withId(LongSupplier idSupplier) {
        if (id != null) {
            throw new IdAlreadyGeneratedException(this);
        }
        id = idSupplier.getAsLong();
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void bookmark(Long surveyId) {
        var bookmark = new SurveyBookmark(surveyId);
        bookmarkedSurveys.add(bookmark);
    }

    public void cancelBookmark(Long surveyId) {
        bookmarkedSurveys.stream()
            .filter(surveyBookmark -> Objects.equals(surveyBookmark.surveyId(), surveyId))
            .findFirst()
            .ifPresent(bookmarkedSurveys::remove);
    }
}
