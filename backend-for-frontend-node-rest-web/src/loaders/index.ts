import expressloader from "./express"
import express from "express"

export default async ({ expressApp }) => {
  await expressloader({ app: expressApp })
  console.info('✌️ Express loaded');
}