# Spring-ai Hand-on

## What is Spring AI?
- Framework for integrating AI into Spring application
- Simplifies adding generative AI using Spring's modular, POJO-based design
- Connects enterprise data and API with AI models seamlessly

## Core Features
- Multi-provider Support : Integrate with OpenAI, Anthropic , AWS, Google, or any model from Hugging face ot other. 
- MCP support: Allows building MCP clients and servers easily
- Vector Store Integration : Support RAG with Pinecone, Redis, PostgresSQL/pgVector, MongoDB, etc.
- Advance Patterns : Chat memory, tool/function calling, and advisor API for reusable AI logic.
- Observability & Guardrails : Monitor AI operations and evaluates outputs to ensure reliability.

## Message Roles in LLMs
- When interacting with large Language Models, we need prompts make up of message. Each message has a role that helps the LLM understand the context and how to respond.

### Common Roles (Used by most APIs)

| Role      | Description                                                   |
| ----------| ------------------------------------------------------------- |
| User      | What the user says or ask. e.g: "Tell me a joke."             |
| System    | Instructions for how the LLM should behave. e.g: "Be formal." |
| Assistant | The LLM's response. e.g: "Sure! Why did the cat ..."          |
| Function  | Special instructions to run a function or fetch data          |