RESOURCES = ../../resources
CWD = $(notdir $(shell pwd))

try-%:
	@cat '$(RESOURCES)/$(CWD)/$(findstring input,$@)$(findstring sample,$@).in' \
		| cargo run -q --bin part$(findstring 1,$@)$(findstring 2,$@)

tall: test1 test2
test%:
	@$(MAKE) --no-print-directory try-sample$(patsubst test%,%,$@) \
		| sdiff -sad "$(RESOURCES)/$(CWD)/sample$(subst test2,Part2,$(subst test1,,$@)).ans" -
