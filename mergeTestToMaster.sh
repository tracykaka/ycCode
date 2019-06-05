#!/usr/bin/env bash
# 合并test分支到master分支
git checkout master
git pull
git merge test -m "merge from test"
git push origin master
git checkout dev