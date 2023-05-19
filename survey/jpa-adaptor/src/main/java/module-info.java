module luffy.survey.jpa.adaptor.main {

	requires luffy.core.data.main;
	requires luffy.survey.application.main;
	requires luffy.survey.domain.main;

	requires spring.data.jpa;

	requires lombok;

	requires spring.tx;
	requires spring.context;
}
