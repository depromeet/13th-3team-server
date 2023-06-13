package me.nalab.auth.application.port.out;

import me.nalab.auth.application.common.dto.OAuthAccessTokenResponse;

import java.net.URI;

/**
 * OAuth 접근을 위한 Web Client Port
 */
public interface OAuthWebClientPort {

    /**
     * OAuth Web Client를 통해 Access 토큰 정보를 가져옵니다
     * @param authToken access token을 가져오기 위한 authentication 정보를 가진 토큰
     * @return Access Token 정보를 가진 dto
     */
    OAuthAccessTokenResponse getAccessToken(String authToken);

    /**
     * 인증을 위한 url을 가져옵니다
     *
     * @return 인증을 위한 redirect url
     */
    URI getAuthorizationUrl(String redirectUrl);
}
