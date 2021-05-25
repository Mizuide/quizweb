export const answerStatus = {none:'none',correct:'correct',incorrect:'incorrect'} as const;
export type answerStatus =typeof answerStatus[keyof typeof answerStatus]; //valueのリテラル値を取る、keyと同一名称のためkeyofでも問題なし
