# Apache Hive Project

## Introduction

This project aims to help users learn and work with **Apache Hive**, a powerful data warehouse tool built on Apache Hadoop. Apache Hive enables querying and managing large datasets using a SQL-like language called **HiveQL**.

The project provides:
- Sample exercises with HiveQL.
- Documentation for installation and usage.
- Common use cases for data analysis.

---

## Goals

1. Understand how Apache Hive operates within the Hadoop ecosystem.
2. Familiarize yourself with HiveQL syntax and functionality.
3. Practice big data processing using Hive.
4. Build efficient tables and queries for large datasets.

---

## Requirements and Installation

### System Requirements
- **Hadoop 3.4.1**.
- **Apache Hive 3.1.3**.
- **Java JDK 8**.
- A machine with at least **8GB RAM** and **50GB disk space**.

### Installation Steps

1. **Install Hadoop:**
   Follow the official Apache Hadoop installation guide: [Hadoop 3.4.1 Documentation](https://hadoop.apache.org/).

2. **Download and Install Apache Hive:**
   ```bash
   # Download Apache Hive 3.1.3
   wget https://downloads.apache.org/hive/hive-3.1.3/apache-hive-3.1.3-bin.tar.gz

   # Extract the archive
   tar -xvzf apache-hive-3.1.3-bin.tar.gz

   # Set environment variables
   export HIVE_HOME=/path/to/apache-hive-3.1.3-bin
   export PATH=$PATH:$HIVE_HOME/bin
