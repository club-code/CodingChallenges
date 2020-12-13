RESOURCES = ../../resources
CWD = $(notdir $(shell pwd))

try-%:
	@cat '$(RESOURCES)/$(CWD)/$(patsubst try-%,%,$@).in' | cargo run -q

test:
	@$(MAKE) --no-print-directory try-sample \
		| sdiff -sad '$(RESOURCES)/$(CWD)/sample.ans' -
