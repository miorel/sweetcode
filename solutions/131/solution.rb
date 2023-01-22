class String
  def is_palindrome?(lo, hi)
    while lo < hi
      return false if self[lo] != self[hi]
      lo += 1
      hi -= 1
    end
    true
  end
end

# @param {String} s
# @return {String[][]}
def partition(s)
  res = []
  
  cur = []
  traverse = lambda do |lo|
    if lo == s.size
      res << cur.dup
      return
    end

    (lo...s.size).each do |hi|
      next unless s.is_palindrome?(lo, hi)
      cur << s[lo..hi]
      traverse.(hi + 1)
      cur.pop
    end
  end

  traverse.(0)

  res
end