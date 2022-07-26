Feature: Default

	#As a librarian I should be able to create a new User
	@B26G32-108
	Scenario: As a librarian I should be able to create a new User
		Given librarian is on the home page
		When librarian clicks Users module
		And librarian clicks Add User button
		And librarian enters full name,password, email address
		And librarian clicks save changes
		Then verify a new user is created