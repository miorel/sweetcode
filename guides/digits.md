# Iterating over the digits of a non-negative integer

If you need to handle negative integers, you can take the absolute value of the integer.

## Approach 1:

Convert the integer to a string, and iterate over the characters of the resulting string in whichever way you prefer.

## Approach 2:

Modding by 10 gives you the last digit of the integer.

Keep modding the number by 10 until you get to 0.

## C++

### Approach 1:

### Approach 2:

## Java

```java
List<Integer> getDigits(int n) {
  List<Integer> digits = new ArrayList<>();

  do {
    digits.add(n % 10);
    n /= 10;
  } while (n != 0);

  Collections.reverse(digits);
  return digits;
}
```

```java
int[] getDigits(int n) {
  String digitsAsString = String.valueOf(n);

  int count = digitsAsString.length();
  int[] digits = new int[count];
  for (int i = 0; i < count; ++i) {
    digits[i] = digitsAsString.charAt(i) - '0';
  }

  return digits;
}
```

```java
int[] getDigits(int n) {
  String digitsAsString = String.valueOf(n);

  int count = digitsAsString.length();
  int[] digits = new int[count];
  for (int i = 0; i < count; ++i) {
    digits[i] = digitsAsString.charAt(i) - '0';
  }

  return digits;
}
```

## Python 3 / Python 2

TODO

## C

TODO

## C#

TODO

## JavaScript / TypeScript

### Approach 1

There are a few ways to convert an integer to a string, for example `String(n)`, `` `${n}` ``, or `(n + "")`. I prefer template strings as idiomatic, though it can be argued whether using the `String` constructor is more clear.

So, if you just need the integer as a string:

```typescript
function getDigitsAsString(n: number): string {
  return `${n}`;
}

// Example:
for (const d of getDigitsAsString(123)) {
  console.log(d);
}

// Output:
//   1
//   2
//   3
```

If you need an _array_, for example because you want to do a `.map` on the digits, we'll need to additionally convert the string to an array. We could do `s.split("")`, but given that strings implement the iterable protocol, I like using spread syntax to get an array of characters (i.e. one-character strings):

```typescript
function getDigitsAsStrings(n: number): string[] {
  return [...`${n}`];
}

// Example:
console.log(getDigitsAsString(123).map((d) => `(${d})`));

// Output:
//   [ '(1)', '(2)', '(3)' ]
```

We can additionally convert each digit to a number. To convert a one-character string to a number, we can do `Number(c)`, `parseInt(c, 10)`, or even `(+c)`. If you're coming from Java world, you might even be tempted to try `(c.codePointAt(0) - "0".codePointAt(0))`. Using `parseInt` arguably shows the clearest intent, but I like `Number` here because it can concisely be used with a `.map`. (Side trivia question: what does `['1', '2', '3'].map(parseInt)` evaluate to and why?)

```typescript
function getDigitsAsNumbers(n: number): number[] {
  return [...`${n}`].map(Number);
}

// Example:
console.log(getDigitsAsNumbers(123).map((d) => d + 1));

// Output:
//   [ 2, 3, 4 ]
```

If you find it wasteful that we're creating an array of the digits as strings, and then creating another array with a `.map`, you might prefer a generator function:

```typescript
function* getDigitsAsGenerator(n: number): Generator<number, void, never> {
  for (const d of `${n}`) {
    yield Number(d);
  }
}

// Example:
for (const d of getDigitsAsGenerator(123)) {
  console.log(d + 1);
}

// Output:
//   2
//   3
//   4
```

However, if you preferred the generator function, you probably like Approach 2 even more, so let's get into it!

### Approach 2

TODO: explain

```typescript
function getDigitsAsNumbers(n: number): number[] {
  const digits = [];
  do {
    const d = n % 10;
    digits.push(d);
    n = (n - d) / 10;
  } while (n !== 0);

  return digits.reverse();
}

// Example:
console.log(getDigitsAsNumbers(123).map((d) => d + 1));

// Output:
//   [ 2, 3, 4 ]
```

```typescript
function* getReversedDigitsAsGenerator(
  n: number
): Generator<number, void, never> {
  do {
    const d = n % 10;
    yield d;
    n = (n - d) / 10;
  } while (n !== 0);
}

// Example:
for (const d of getReversedDigitsAsGenerator(123)) {
  console.log(d + 1);
}

// Output:
//   4
//   3
//   2
```

## Ruby

Ruby integers have a `digits` method, so we'd be remiss not to use it! It returns an array of integer digits from least significant to most significant, and [the reference implementation does in fact use Approach 2](https://github.com/ruby/ruby/blob/71ce7e1825c5b8fe08dd96cd77c6a379afd34256/numeric.c#L5467-L5472).

If you need the digits starting from the most significant (and you don't want to iterate over the array using `.reverse_each`), we can explicitly reverse the array.

```ruby
def get_digits(n)
  n.digits.reverse!
end

# Example:
p get_digits(123)

# Output:
#   [1, 2, 3]
```

Perhaps the only reason not to use the core library method is if you'd like to avoid explicitly creating the array of digits. Then you could use a function that takes a block:

```ruby
def each_digit(n)
  loop do
    yield n % 10
    n /= 10
    break if n.zero?
  end
end

# Example:
each_digit(123) { |d| puts d }

# Output:
#   1
#   2
#   3
```

Or an `Enumerator`:

```ruby
def each_digit(n, &block)
  Enumerator.new do |y|
    loop do
      y << (n % 10)
      n /= 10
      break if n.zero?
    end
  end
end

# Example:
each_digit(123).each { |d| puts d }

# Output:
#   1
#   2
#   3
```

For completeness, here's an implementation that goes through the string conversion. But there's no reason to do this when `Integer#digits` exists.

```ruby
def get_digits_bad_just_use_the_digits_method(n)
  n.to_s.each_char.map(&:to_i)
end

# Example:
p get_digits_bad_just_use_the_digits_method(123)

# Output:
#   [1, 2, 3]
```

## Swift

TODO

## Go

TODO

## Scala

TODO

## Kotlin

TODO

## Rust

TODO

## PHP

TODO

## Racket

TODO

## Erlang

TODO

## Elixir

TODO

## Dart

TODO
