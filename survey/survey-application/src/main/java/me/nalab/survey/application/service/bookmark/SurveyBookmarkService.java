package me.nalab.survey.application.service.bookmark;

import lombok.RequiredArgsConstructor;
import me.nalab.survey.application.common.survey.dto.SurveyBookmarkDto;
import me.nalab.survey.application.exception.SurveyDoesNotExistException;
import me.nalab.survey.application.port.in.web.bookmark.SurveyBookmarkUseCase;
import me.nalab.survey.application.port.out.persistence.bookmark.SurveyBookmarkListenPort;
import me.nalab.survey.application.port.out.persistence.bookmark.SurveyBookmarkPort;
import me.nalab.survey.application.port.out.persistence.findfeedback.SurveyExistCheckPort;
import me.nalab.survey.application.port.out.persistence.findtarget.TargetFindPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SurveyBookmarkService implements SurveyBookmarkUseCase {

    private final TargetFindPort targetFindPort;
    private final SurveyExistCheckPort surveyExistCheckPort;
    private final SurveyBookmarkPort surveyBookmarkPort;
    private final SurveyBookmarkListenPort surveyBookmarkListener;

    @Override
    @Transactional
    public SurveyBookmarkDto bookmark(Long targetId, Long surveyId) {
        var target = targetFindPort.getTargetById(targetId);

        if (!surveyExistCheckPort.isExistSurveyBySurveyId(surveyId)) {
            throw new SurveyDoesNotExistException(surveyId);
        }

        target.bookmark(surveyId);
        surveyBookmarkPort.bookmark(target);

        surveyBookmarkListener.listenBookmarked(targetId);

        return SurveyBookmarkDto.from(surveyId, target);
    }
}