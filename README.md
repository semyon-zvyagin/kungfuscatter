# 🥋 KungFuScatter 🥋

Welcome to **KungFuScatter**, the Kotlin library that kicks obfuscation into high gear! 🚀

## What is KungFuScatter?

Imagine you have a set of numbers, and you want to mix them up like a master of martial arts mixing up their moves. But instead of just jumbling things up randomly, you want to make sure that every number gets a unique new value—so if you know the secret moves (a.k.a. the "key"), you can always reverse the changes. That's exactly what *KungFuScatter* does!

With this library, you can transform numbers in a way that hides their original sequence but still keeps a one-to-one relationship between the original and transformed values. This is called a **bijection**—a fancy math term that means every number gets matched up with a unique new number, like pairing up dance partners!

## Why is it called KungFuScatter? 🥋✨

Well, the name is a bit of a joke! Here's the story:

- **KungFu**: We wanted a name that sounds strong and dynamic—like a martial artist doing flips and kicks! And what could be better than *Kung Fu*, the famous Chinese martial art? Just like in Kung Fu, where every move is precise and controlled, our library carefully transforms each number into a new one.
- **K** for **Kotlin**: Since this library is written in Kotlin, we just had to put a "K" at the front—like a secret move that only Kotlin coders know!
- **Scatter**: The goal of the library is to scatter (or shuffle) values in a way that hides the original sequence. But don't worry, it's not random chaos—it's a controlled and reversible process!

So, put it all together, and you get... *KungFuScatter*! A library that lets you *scatter* your numbers like a true martial arts master, but with the precision of Kotlin code.

## Why Use KungFuScatter? 🤔

There are lots of reasons you might want to use *KungFuScatter*. Here are a couple of scenarios:

### 1. Hide Your IDs
Imagine you have a simple counter that gives out IDs like 1, 2, 3... and so on. If you use these IDs directly in URLs or APIs, it might give away too much information. For example, a competitor could figure out how many orders your online store gets each day just by looking at the IDs.

With *KungFuScatter*, you can transform those IDs before sending them out. That way, your internal IDs stay hidden, but you can still reverse the process when needed.

### 2. Make Logs Obfuscated but Usable

Ever needed to log sensitive data, like IP addresses, but didn't want to expose the actual values? You don’t want to just mask the IP address because then you lose the ability to trace similar entries back to the same user or location.

With **KungFuScatter**, you can scramble the IP addresses in a way that keeps each one unique but hides the actual address.

## How It Works

- **Salt**: The "salt" is a secret ingredient that ensures your numbers are mixed up in a unique way. Think of it like a secret Kung Fu technique that only you know! It makes sure that even if someone else uses the same numbers, they won’t get the same result without your secret salt.
- **Bijection**: This means that every input number has a unique transformed number and vice versa. You can always reverse the process if you know the secret moves (a.k.a. the salt). It’s like having a secret map that lets you find your way back to the original numbers.
- **Range**: You define the range of numbers that you want to transform. For example, `from = 1` and `to = 100` means you're transforming numbers between 1 and 100. This range helps keep everything contained, like a martial artist training within the dojo!

## Join the Kung Fu Community!

Got a question or an idea to make this library even better? Join the dojo! We welcome fellow Kotlin developers, code warriors, and curious minds.

- 🐛 **Found a bug?** Open an issue, and we'll put our debugging skills to the test.
- 🌟 **Like the library?** Give it a star to show your appreciation.
- 💡 **Want to contribute?** Feel free to submit a pull request. We’re all about growing our Kung Fu skills together.

Remember, the more you share, the stronger our Kung Fu gets. 🥋✨