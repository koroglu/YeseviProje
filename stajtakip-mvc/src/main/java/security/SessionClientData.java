package security;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SessionClientData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
