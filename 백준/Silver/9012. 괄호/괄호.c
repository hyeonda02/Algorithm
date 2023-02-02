#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_STACK_SIZE 100
//괄호
typedef char element;
typedef struct {
	element* data[MAX_STACK_SIZE];
	int top;
}StackType;
void init_stack(StackType* s) {
	s->top = -1;
}
int is_full(StackType* s) {
	return (s->top == MAX_STACK_SIZE - 1);
}
int is_empty(StackType* s) {
	return (s->top == -1);
}
void push(StackType* s,element item) {
	if (is_full(s)) {
		fprintf(stderr, "스택 포화 에러\n");
		exit(1);
	}
	else
		s->data[++(s->top)] = item;

}
element peek(StackType* s) {
	if (is_empty(s)) {
		fprintf(stderr, "스택 공백 에러\n");
		exit(1);
	}
	else
		return s->data[(s->top)];
}
element pop(StackType* s) {
	if (is_empty(s)) {
		fprintf(stderr, "스택 공백 에러\n");
		exit(1);
	}
	else
		return s->data[(s->top)--];
}
int check_correct(char in[]) {
	StackType s;
	init_stack(&s);
	int num = strlen(in);
	for (int i = 0; i < num; i++) {
		char n = in[i];
		if (n == '(')
			push(&s, n);
		else if (n == ')') {
			if (is_empty(&s)==1)
				return 0;
			else
				pop(&s);
		}

	}
	if (is_empty(&s) == 1) {
		return 1;
	}
	else
		return 0;
}
int main() {
	int T;
	int result;
	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		char input[50];
		scanf("%s", input);
		result=check_correct(input);
		if (result==1)
			printf("YES\n");
		else
			printf("NO\n");

	}
}