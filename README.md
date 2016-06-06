# RestJerseySecurity Example (Programatic)
Rest Security:
--------------
1.) Authentication:
	following are authentication protocol where Rest service using:
		(a). Basic:
			Simplest protocol over HTTP.
			Client sends Base-64 encoded userid and password within request header.
			if user failed to authenticate the server send response 401 Unauthorization code.
			WWW-Authenticate: tell which authentication protocol client should use.
		(b). Digest:
			Client has not to send text password over HTTP.
			It exchange the MD5 hashes of the username,password,operation,URI and messge body.
			
				H1=MD5(username:realm:password)
				H2=MD5(httpmethod;uri)
				response=MD5(H1+":nonce:nc:cnonce:qop:"+H2)
			limitation of this protocol is using must HTTPS
		(c). X.509(client_cert) (Client certification):
			exchange digitally signed certificate between client and server.
			No need of user authentication over HTTP
			Most secure way to perform authentication.

	---Validity the identity of client who trying to access the resource.
	---example: userid and password credentials.
	
2). Authorization:
	whether certail user will allow to access or invoke perticular resource.
	It performs by associating one or more roles.

Process:
-----------
Configuring Security:
	(i).  Container managed security
	(ii). JAX-RS SecurityContext (Programatic)
	(iii). Declarative Security
