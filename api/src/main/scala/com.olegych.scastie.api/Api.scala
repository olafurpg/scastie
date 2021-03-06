package com.olegych.scastie
package api

import scala.concurrent.Future

trait Api {
  def run(inputs: Inputs): Future[SnippetId]
  def format(code: FormatRequest): Future[FormatResponse]

  def save(inputs: Inputs): Future[SnippetId]
  def amend(snippetId: SnippetId, inputs: Inputs): Future[Boolean]
  def update(snippetId: SnippetId, inputs: Inputs): Future[Option[SnippetId]]
  def delete(snippetId: SnippetId): Future[Boolean]

  def fork(snippetId: SnippetId, inputs: Inputs): Future[Option[SnippetId]]

  def fetch(snippetId: SnippetId): Future[Option[FetchResult]]
  def fetchUser(): Future[Option[User]]
  def fetchUserSnippets(): Future[List[SnippetSummary]]
}
