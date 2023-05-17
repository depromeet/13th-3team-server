module luffy.survey.application.main {

	exports me.nalab.survey.application.common.dto;
	exports me.nalab.survey.application.port.in.web;
	exports me.nalab.survey.application.port.out.persistence;

	requires luffy.survey.domain.main;
	requires luffy.core.id.generator.id.generator.starter.main;

	requires lombok;

	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.tx;

}
