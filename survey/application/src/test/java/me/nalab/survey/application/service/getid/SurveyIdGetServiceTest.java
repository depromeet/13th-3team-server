package me.nalab.survey.application.service.getid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import me.nalab.survey.application.exception.TargetDoesNotHasSurveyException;
import me.nalab.survey.application.port.in.web.getid.SurveyIdGetUseCase;
import me.nalab.survey.application.port.out.persistence.findid.SurveyIdFindPort;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SurveyIdGetService.class)
class SurveyIdGetServiceTest {

	@Autowired
	private SurveyIdGetUseCase surveyIdGetUseCase;

	@MockBean
	private SurveyIdFindPort surveyIdFindPort;

	@Test
	@DisplayName("SurveyId List 조회 성공 테스트")
	void GET_SURVEY_ID_LIST_SUCCESS() {
		// given
		Long expectedSurveyId = 1L;

		// when
		when(surveyIdFindPort.findSurveyIdByTargetId(anyLong())).thenReturn(Optional.of(expectedSurveyId));

		Long resultSurveyIdList = surveyIdGetUseCase.getSurveyIdByTargetId(1L);

		// then
		assertEquals(expectedSurveyId, resultSurveyIdList);
	}

	@Test
	@DisplayName("SurveyId List 조회 실패 테스트 - empty")
	void GET_SURVEY_ID_LIST_FAIL_EMPTY_OPTIONAL() {
		// when
		when(surveyIdFindPort.findSurveyIdByTargetId(anyLong())).thenReturn(Optional.empty());

		// then
		assertThrows(TargetDoesNotHasSurveyException.class, () -> surveyIdGetUseCase.getSurveyIdByTargetId(1L));
	}

}