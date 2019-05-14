#!/usr/bin/env bash
# 合并dev分支到test分支
git checkout dev
git pull
git checkout test
git merge dev -m "merge from dev"
git push origin test
git checkout dev