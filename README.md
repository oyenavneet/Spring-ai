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

### Prompt Templates in Spring AI
** Why use Prompt Templates **
- Simplified prompt constructions
- Make prompts reusable and maintainable
- Keeps logic and text cleanly separated
- Supports parameterized placeholders like {customerName}

### Prompt Stuffing
It gives LLM an open book before answering a questing
- You include contextual data or reference text along with the user's questions.
- The LLM uses this extra content to answer the question accurately - event if it want not pre-trained on the topic
- This technique is also known as in-context learning or retrieval-augmented prompting (when done programmatically)

### Advisors
In Spring AI,advisors are like interceptors or middleware for yor prompt flow.

**Advisors allow you to:**

- Pre-process or post-process prompt data.
- Add custom logging or auditing
- Inject additional behavior without modifying core logic.
- Chain multiple behaviors cleanly

*User -> ChatClient -> [Advisors] -> LLM -> Response -> [Advisors] -> User*

***Spring AI Provide some build-in-advisors, and you can create your own.***

- SimpleLoggerAdvisor
- SafeGuardAdvisor
- PromptChatMemoryAdvisor etc.

### ChatOptions in Spring Ai

- ChatOptions is a configuration in Spring AI that allows you to customize how a language behaves during chat/completion calls.
- Think of it like a "tunning panel" for you AI model - ypu can set limits, adjust creativity, randomness, verbosity, control response, length, and more.

**Key Chat Options**

| Options           | Meaning                                        |
|-------------------|------------------------------------------------|
| model             | Which LLM model to use e.g: gpt-4 etc          |
| frequencyPenalty  | Reduces repetition. Higher = less repetition   |
| presencePenalty   | Encourages mentioning new topics.              |
| temperature       | Controls creativity, 0 = focused, 1 = random   |
| topP              | Controls randomness (nucleus sampling)         |
| stopSequences     | Stop generating when specific phrase are found | 
| maxTokens         | Maximum number of tokens in the reply          |
| topK              | controls how many top choices are considered   |

## Chat Memory using Spring AI

- LLMs don't remember past chats. Each interaction is like fresh start - no memory!
- This can be a problem if you want to maintain conversation context across multiple interactions.

**Spring AI's Chat Memory**

- Spring AI gives us the ChatMemory abstractions to store and manage conversation history.
- Messages are saved using a ChatMemoryRepository - similar to storage engine behind the scenes

**Flexible Memory Strategies**

- Keep only last N messages
- Store message for a specific time window
- Retain message until a token limit is reached

**With ChatMemory, LLMs can behave more like a human - remember the past to improve the response**