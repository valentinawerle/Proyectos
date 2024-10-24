/**
 * @typedef {'Jira'|'Linux'|'Figma'|'Postman'|'GitHub'|'VS Code'|'Notion'|'SQL'} ToolName
 * @typedef {'Python'|'Java'|'C'|'TypeScript'|'JavaScript'|'HTML'|'CSS'|'Arduino'} LangName
 * @typedef {{ name: ToolName, icon: string }} Tools
 * @typedef {{ name: LangName, icon: string }} Languages
 */

/** @type {Array<Languages>} */
const LANGUAGES = [
  {
    name: 'Python',
    icon: 'https://upload.wikimedia.org/wikipedia/commons/c/c3/Python-logo-notext.svg'
  },
  {
    name: 'Java',
    icon: 'https://img.icons8.com/?size=100&id=13679&format=png&color=000000'
  },
  {
    name: 'C',
    icon: 'https://img.icons8.com/?size=512&id=40670&format=png'
  },
  {
    name: 'TypeScript',
    icon: 'https://img.icons8.com/?size=100&id=wpZmKzk11AzJ&format=png&color=000000'
  },
  {
    name: 'JavaScript',
    icon: 'https://img.icons8.com/?size=100&id=108784&format=png&color=000000'
  },
  {
    name: 'HTML',
    icon: 'https://img.icons8.com/?size=100&id=20909&format=png&color=000000'
  },
  {
    name: 'CSS',
    icon: 'https://img.icons8.com/?size=100&id=21278&format=png&color=000000'
  },
  {
    name: 'Arduino',
    icon: 'https://img.icons8.com/?size=100&id=13444&format=png&color=000000'
  }
];

/** @type {Array<Tools>} */
const TOOLS = [
  {
    name: 'Jira',
    icon: 'https://cdn-icons-png.flaticon.com/512/5968/5968875.png'
  },
  {
    name: 'Linux',
    icon: 'https://img.icons8.com/?size=100&id=17842&format=png&color=000000'
  },
  {
    name: 'Figma',
    icon: 'https://img.icons8.com/?size=100&id=W0YEwBDDfTeu&format=png&color=000000'
  },
  {
    name: 'Postman',
    icon: 'https://cdn.iconscout.com/icon/free/png-256/free-cartero-3628992-3030217.png?f=webp'
  },
  {
    name: 'GitHub',
    icon: 'https://img.icons8.com/m_sharp/200/FFFFFF/github.png'
  },
  {
    name: 'VS Code',
    icon: 'https://img.icons8.com/?size=100&id=9OGIyU8hrxW5&format=png&color=000000'
  },
  {
    name: 'Notion',
    icon: 'https://img.icons8.com/?size=100&id=nvtEH6DpqruC&format=png&color=000000'
  },
  {
    name: 'SQL',
    icon: 'https://img.icons8.com/?size=100&id=qGUfLiYi1bRN&format=png&color=000000'
  }
]

export {
  LANGUAGES,
  TOOLS
};

export default {
  LANGUAGES,
  TOOLS
}
