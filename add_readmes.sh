#!/bin/bash

ls | perl -nle 'open my $fh, ">$_/README.md"; s/^\d+\-//; print $fh "[View the problem on LeetCode](https://leetcode.com/problems/$_/)\n"; close $fh'
